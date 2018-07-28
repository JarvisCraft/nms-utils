package ru.progrm_jarvis.minecraft.nmsutil;

import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.wrappers.Vector3F;
import lombok.*;
import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import ru.progrm_jarvis.minecraft.nmsutil.datawatcher.DataWatcherBuilder;
import ru.progrm_jarvis.minecraft.nmsutil.datawatcher.LatestDataWatcherBuilder;
import ru.progrm_jarvis.minecraft.nmsutil.datawatcher.LegacyDataWatcherBuilder;
import ru.progrm_jarvis.reflector.wrapper.FieldWrapper;

import static lombok.AccessLevel.NONE;
import static ru.progrm_jarvis.reflector.Reflector.classForName;
import static ru.progrm_jarvis.reflector.Reflector.getDeclaredField;

@UtilityClass
@SuppressWarnings("unused")
public class NmsManager {

    @Getter private final NmsVersion NMS_VERSION = NmsVersion.computeCurrent();
    private final FieldWrapper<?, Integer> ENTITY_COUNT_FIELD = getDeclaredField(
            classForName(getNmsPackage().concat(".Entity")), "entityCount"
    );
    public final DataWatcherBuilder DATA_WATCHER_BUILDER = NMS_VERSION.generation < 9
            ? new LegacyDataWatcherBuilder() : new LatestDataWatcherBuilder();

    private final EquivalentConverter<Vector3F> VECTOR_3F_CONVERTER = Vector3F.getConverter();

    public String getNmsPackage() {
        return "net.minecraft.server.".concat(NMS_VERSION.name);
}

    public String getCraftBukkitPackage() {
        return "org.bukkit.craftbukkit.".concat(NMS_VERSION.name);
    }

    public int nextEntityId() {
        synchronized (ENTITY_COUNT_FIELD) {
            return ENTITY_COUNT_FIELD.updateValue(id -> id + 1);
        }
    }

    @Value
    @RequiredArgsConstructor(access = NONE)
    public static final class NmsVersion {

        @NonNull
        private final String name;
        private final short generation;

        private NmsVersion(final String name) {
            if (name == null) throw new NullPointerException("name");

            this.name = name;
            generation = Short.parseShort(name.substring(3, name.indexOf('_', 4)));
        }

        public static NmsVersion computeCurrent() {
            val craftServerPackage = Bukkit.getServer().getClass().getPackage().getName();
            return new NmsVersion(craftServerPackage.substring(craftServerPackage.lastIndexOf('.') + 1));
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Transformers
    ///////////////////////////////////////////////////////////////////////////

    public Object toNms(final Vector3F vector3F) {
        return Vector3F.getConverter().getGeneric(Vector3F.getMinecraftClass(), vector3F);
    }

    public Object vector3FFromNms(final Object vector3f) {
        return VECTOR_3F_CONVERTER.getSpecific(vector3f);
    }
}
