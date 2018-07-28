package ru.progrm_jarvis.minecraft.nmsutil.datawatcher;

import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.Vector3F;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import com.comphenix.protocol.wrappers.WrappedWatchableObject;
import org.bukkit.inventory.ItemStack;
import ru.progrm_jarvis.minecraft.nmsutil.NmsManager;

import java.util.Optional;
import java.util.UUID;

public interface DataWatcherBuilder {

    WrappedWatchableObject createWatchable(int id, Byte value);

    WrappedWatchableObject createWatchable(int id, Integer value);

    WrappedWatchableObject createWatchable(int id, Float value);

    WrappedWatchableObject createWatchable(int id, String value);

    WrappedWatchableObject createWatchableIChatBaseComponent(int id, Object value);

    WrappedWatchableObject createWatchableItemStack(int id, Object value);

    default WrappedWatchableObject createWatchable(final int id, final ItemStack value) {
        return createWatchableItemStack(id, MinecraftReflection.getMinecraftItemStack(value));
    }

    WrappedWatchableObject createWatchableOptionalIBlockData(int id, Optional<Object> value);

    WrappedWatchableObject createWatchable(int id, Boolean value);

    WrappedWatchableObject createWatchableVector3f(int id, Object value);

    WrappedWatchableObject createWatchable(int id, BlockPosition value);

    WrappedWatchableObject createWatchable(int id, Optional<BlockPosition> value);

    WrappedWatchableObject createWatchableEnumDirection(int id, Object value);

    WrappedWatchableObject createWatchableOptionalUUID(int id, Optional<UUID> value);

    WrappedWatchableObject createWatchableNBTTagCompound(int id, Object value);

    WrappedWatchableObject createWatchable(int id, Object value);

    Builder builder(WrappedDataWatcher watcher);

    Builder builder();

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    interface Builder {

        Builder clone();

        Builder set(int id, Byte value);

        Builder set(int id, Integer value);

        Builder set(int id, Float value);

        Builder set(int id, String value);

        Builder setIChatBaseComponent(int id, Object value);

        Builder setItemStack(int id, Object value);

        default Builder set(final int id, final ItemStack value) {
            return setItemStack(id, MinecraftReflection.getMinecraftItemStack(value));
        }

        Builder setOptionalIBlockData(int id, Optional<Object> value);

        Builder set(int id, Boolean value);

        Builder setVector3f(int id, Object value);

        default Builder set(final int id, final Vector3F value) {
            return setVector3f(id, NmsManager.toNms(value));
        }

        Builder set(int id, BlockPosition value);

        Builder set(int id, Optional<BlockPosition> value);

        Builder setEnumDirection(int id, Object value);

        Builder setNBTTagCompound(int id, Object value);

        Builder setOptionalUUID(int id, Object value);

        // should be used if and only if none of default #set(id, value) methods don't provide type given
        Builder set(int id, Object value);

        WrappedDataWatcher build();
    }
}
