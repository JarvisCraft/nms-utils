package ru.progrm_jarvis.minecraft.nmsutil.datawatcher;

import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import com.comphenix.protocol.wrappers.WrappedWatchableObject;
import lombok.RequiredArgsConstructor;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;
import java.util.UUID;

public class LegacyDataWatcherBuilder implements DataWatcherBuilder {

    @Override
    public Builder builder(WrappedDataWatcher watcher) {
        return new Builder(watcher);
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    @Override
    public WrappedWatchableObject createWatchable(final int id, final Byte value) {
        return new WrappedWatchableObject(id, value);
    }

    @Override
    public WrappedWatchableObject createWatchable(final int id, final Integer value) {
        return new WrappedWatchableObject(id, value);
    }

    @Override
    public WrappedWatchableObject createWatchable(final int id, final Float value) {
        return new WrappedWatchableObject(id, value);
    }

    @Override
    public WrappedWatchableObject createWatchable(final int id, final String value) {
        return new WrappedWatchableObject(id, value);
    }

    @Override
    public WrappedWatchableObject createWatchableIChatBaseComponent(final int id, final Object value) {
        return new WrappedWatchableObject(id, value);
    }

    @Override
    public WrappedWatchableObject createWatchableItemStack(final int id, final Object value) {
        return new WrappedWatchableObject(id, value);
    }

    @Override
    public WrappedWatchableObject createWatchableOptionalIBlockData(final int id, final Optional<Object> value) {
        return new WrappedWatchableObject(id, value);
    }

    @Override
    public WrappedWatchableObject createWatchable(final int id, final Boolean value) {
        return new WrappedWatchableObject(id, value);
    }

    @Override
    public WrappedWatchableObject createWatchableVector3f(final int id, final Object value) {
        return new WrappedWatchableObject(id, value);
    }

    @Override
    public WrappedWatchableObject createWatchable(final int id, final BlockPosition value) {
        return new WrappedWatchableObject(id, value);
    }

    @Override
    public WrappedWatchableObject createWatchable(final int id, final Optional<BlockPosition> value) {
        return new WrappedWatchableObject(id, value);
    }

    @Override
    public WrappedWatchableObject createWatchableEnumDirection(final int id, final Object value) {
        return new WrappedWatchableObject(id, value);
    }

    @Override
    public WrappedWatchableObject createWatchableOptionalUUID(final int id, final Optional<UUID> value) {
        return new WrappedWatchableObject(id, value);
    }

    @Override
    public WrappedWatchableObject createWatchableNBTTagCompound(final int id, final Object value) {
        return new WrappedWatchableObject(id, value);
    }

    @Override
    public WrappedWatchableObject createWatchable(final int id, final Object value) {
        return new WrappedWatchableObject(id, value);
    }

    @RequiredArgsConstructor
    private class Builder implements DataWatcherBuilder.Builder {

        private final WrappedDataWatcher dataWatcher;

        private Builder() {
            this(new WrappedDataWatcher());
        }

        @Override
        @SuppressWarnings("MethodDoesntCallSuperMethod")
        public DataWatcherBuilder.Builder clone() {
            return new Builder(dataWatcher.deepClone());
        }

        @Override
        public WrappedDataWatcher build() {
            return dataWatcher;
        }

        @Override
        public Builder set(final int id, final Byte value) {
            dataWatcher.setObject(id, value);

            return this;
        }

        @Override
        public Builder set(final int id, final Integer value) {
            dataWatcher.setObject(id, value);

            return this;
        }

        @Override
        public Builder set(final int id, final Float value) {
            dataWatcher.setObject(id, value);

            return this;
        }

        @Override
        public Builder set(final int id, final String value) {
            dataWatcher.setObject(id, value);

            return this;
        }

        @Override
        public Builder setIChatBaseComponent(final int id, final Object value) {
            dataWatcher.setObject(id, value);

            return this;
        }


        @Override
        public Builder setItemStack(final int id, final Object value) {
            dataWatcher.setObject(id, value);

            return this;
        }

        @Override
        public Builder set(final int id, final ItemStack value) {
            dataWatcher.setObject(id, MinecraftReflection.getMinecraftItemStack(value));

            return this;
        }

        @Override
        public Builder setOptionalIBlockData(final int id, final Optional<Object> value) {
            dataWatcher.setObject(id, value);

            return this;
        }

        @Override
        public Builder set(final int id, final Boolean value) {
            dataWatcher.setObject(id, value);

            return this;
        }

        @Override
        public Builder setVector3f(final int id, final Object value) {
            dataWatcher.setObject(id, value);

            return this;
        }

        @Override
        public Builder set(final int id, final BlockPosition value) {
            dataWatcher.setObject(id, value);

            return this;
        }

        @Override
        public Builder set(final int id, final Optional<BlockPosition> value) {
            dataWatcher.setObject(id, value);

            return this;
        }

        @Override
        public Builder setEnumDirection(final int id, final Object value) {
            dataWatcher.setObject(id, value);

            return this;
        }

        @Override
        public Builder setNBTTagCompound(final int id, final Object value) {
            dataWatcher.setObject(id, value);

            return this;
        }

        @Override
        public Builder setOptionalUUID(final int id, final Object value) {
            dataWatcher.setObject(id, value);

            return this;
        }

        // should be used if and only if none of default #set(id, value) methods don't provide type given
        @Override
        public Builder set(final int id, final Object value) {
            dataWatcher.setObject(id, value);

            return this;
        }
    }
}
