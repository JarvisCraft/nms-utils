package ru.progrm_jarvis.minecraft.nmsutil.datawatcher;

import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import com.comphenix.protocol.wrappers.WrappedDataWatcher.Registry;
import com.comphenix.protocol.wrappers.WrappedWatchableObject;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

public class LatestDataWatcherBuilder implements DataWatcherBuilder {

    public final WrappedDataWatcher.Serializer
            BYTE_SERIALIZER = Registry.get(Byte.class),
            INTEGER_SERIALIZER = Registry.get(Integer.class),
            FLOAT_SERIALIZER = Registry.get(Float.class),
            STRING_SERIALIZER = Registry.get(String.class),
            I_CHAT_BASE_COMPONENT_SERIALIZER = Registry.getChatComponentSerializer(),
            ITEM_STACK_SERIALIZER = Registry.getItemStackSerializer(false),
            OPTIONAL_I_BLOCK_DATA_SERIALIZER = Registry.getBlockDataSerializer(true),
            BOOLEAN_SERIALIZER = Registry.get(Boolean.class),
            VECTOR_3F_SERIALIZER = Registry.getVectorSerializer(),
            BLOCK_POSITION_SERIALIZER = Registry.getBlockPositionSerializer(false),
            OPTIONAL_BLOCK_POSITION_SERIALIZER = Registry.getBlockPositionSerializer(true),
            ENUM_DIRECTION_SERIALIZER = Registry.getDirectionSerializer(),
            OPTIONAL_UUID_SERIALIZER = Registry.getUUIDSerializer(true),
            NBT_TAG_COMPOUND_SERIALIZER = Registry.getNBTCompoundSerializer(),
            OBJECT_SERIALIZER = Registry.get(Object.class);

    public WrappedDataWatcher.WrappedDataWatcherObject watcherObjectByte(final int id) {
        return new WrappedDataWatcher.WrappedDataWatcherObject(id, BYTE_SERIALIZER);
    }

    public WrappedDataWatcher.WrappedDataWatcherObject watcherObjectInteger(final int id) {
        return new WrappedDataWatcher.WrappedDataWatcherObject(id, INTEGER_SERIALIZER);
    }

    public WrappedDataWatcher.WrappedDataWatcherObject watcherObjectFloat(final int id) {
        return new WrappedDataWatcher.WrappedDataWatcherObject(id, FLOAT_SERIALIZER);
    }

    public WrappedDataWatcher.WrappedDataWatcherObject watcherObjectString(final int id) {
        return new WrappedDataWatcher.WrappedDataWatcherObject(id, STRING_SERIALIZER);
    }

    public WrappedDataWatcher.WrappedDataWatcherObject watcherObjectIChatBaseComponent(final int id) {
        return new WrappedDataWatcher.WrappedDataWatcherObject(id, I_CHAT_BASE_COMPONENT_SERIALIZER);
    }

    public WrappedDataWatcher.WrappedDataWatcherObject watcherObjectItemStack(final int id) {
        return new WrappedDataWatcher.WrappedDataWatcherObject(id, ITEM_STACK_SERIALIZER);
    }

    public WrappedDataWatcher.WrappedDataWatcherObject watcherObjectOptionalIBlockData(final int id) {
        return new WrappedDataWatcher.WrappedDataWatcherObject(id, OPTIONAL_I_BLOCK_DATA_SERIALIZER);
    }

    public WrappedDataWatcher.WrappedDataWatcherObject watcherObjectBoolean(final int id) {
        return new WrappedDataWatcher.WrappedDataWatcherObject(id, BOOLEAN_SERIALIZER);
    }

    public WrappedDataWatcher.WrappedDataWatcherObject watcherObjectVector3f(final int id) {
        return new WrappedDataWatcher.WrappedDataWatcherObject(id, VECTOR_3F_SERIALIZER);
    }

    public WrappedDataWatcher.WrappedDataWatcherObject watcherObjectBlockPosition(final int id) {
        return new WrappedDataWatcher.WrappedDataWatcherObject(id, BLOCK_POSITION_SERIALIZER);
    }

    public WrappedDataWatcher.WrappedDataWatcherObject watcherObjectOptionalBlockPosition(final int id) {
        return new WrappedDataWatcher.WrappedDataWatcherObject(id, OPTIONAL_BLOCK_POSITION_SERIALIZER);
    }

    public WrappedDataWatcher.WrappedDataWatcherObject watcherObjectEnumDirection(final int id) {
        return new WrappedDataWatcher.WrappedDataWatcherObject(id, ENUM_DIRECTION_SERIALIZER);
    }

    public WrappedDataWatcher.WrappedDataWatcherObject watcherObjectOptionalUUID(final int id) {
        return new WrappedDataWatcher.WrappedDataWatcherObject(id, OPTIONAL_UUID_SERIALIZER);
    }

    public WrappedDataWatcher.WrappedDataWatcherObject watcherObjectNBTTagCompound(final int id) {
        return new WrappedDataWatcher.WrappedDataWatcherObject(id, NBT_TAG_COMPOUND_SERIALIZER);
    }

    public WrappedDataWatcher.WrappedDataWatcherObject watcherObjectObject(final int id) {
        return new WrappedDataWatcher.WrappedDataWatcherObject(id, OBJECT_SERIALIZER);
    }

    ///////////////////////////////////////////////////////////////////////////
    // #createWatchable(id, value)
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public WrappedWatchableObject createWatchable(final int id, final Byte value) {
        return new WrappedWatchableObject(watcherObjectByte(id), value);
    }

    @Override
    public WrappedWatchableObject createWatchable(final int id, final Integer value) {
        return new WrappedWatchableObject(watcherObjectInteger(id), value);
    }

    @Override
    public WrappedWatchableObject createWatchable(final int id, final Float value) {
        return new WrappedWatchableObject(watcherObjectFloat(id), value);
    }

    @Override
    public WrappedWatchableObject createWatchable(final int id, final String value) {
        return new WrappedWatchableObject(watcherObjectString(id), value);
    }

    @Override
    public WrappedWatchableObject createWatchableIChatBaseComponent(final int id, final Object value) {
        return new WrappedWatchableObject(watcherObjectIChatBaseComponent(id), value);
    }

    @Override
    public WrappedWatchableObject createWatchableItemStack(final int id, final Object value) {
        return new WrappedWatchableObject(watcherObjectItemStack(id), value);
    }

    @Override
    public WrappedWatchableObject createWatchableOptionalIBlockData(final int id, final Optional<Object> value) {
        return new WrappedWatchableObject(watcherObjectOptionalIBlockData(id), value);
    }

    @Override
    public WrappedWatchableObject createWatchable(final int id, final Boolean value) {
        return new WrappedWatchableObject(watcherObjectBoolean(id), value);
    }

    @Override
    public WrappedWatchableObject createWatchableVector3f(final int id, final Object value) {
        return new WrappedWatchableObject(watcherObjectVector3f(id), value);
    }

    @Override
    public WrappedWatchableObject createWatchable(final int id, final BlockPosition value) {
        return new WrappedWatchableObject(watcherObjectBlockPosition(id), value);
    }

    @Override
    public WrappedWatchableObject createWatchable(final int id, final Optional<BlockPosition> value) {
        return new WrappedWatchableObject(watcherObjectOptionalBlockPosition(id), value);
    }

    @Override
    public WrappedWatchableObject createWatchableEnumDirection(final int id, final Object value) {
        return new WrappedWatchableObject(watcherObjectEnumDirection(id), value);
    }

    @Override
    public WrappedWatchableObject createWatchableOptionalUUID(final int id, final Optional<UUID> value) {
        return new WrappedWatchableObject(watcherObjectOptionalUUID(id), value);
    }

    @Override
    public WrappedWatchableObject createWatchableNBTTagCompound(final int id, final Object value) {
        return new WrappedWatchableObject(watcherObjectNBTTagCompound(id), value);
    }

    @Override
    public WrappedWatchableObject createWatchable(final int id, final Object value) {
        return new WrappedWatchableObject(watcherObjectObject(id), value);
    }

    @Override
    public Builder builder(WrappedDataWatcher watcher) {
        return new Builder(watcher);
    }

    @Override
    public Builder builder() {
        return new Builder();
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
        public Builder set(final int id, final Byte value) {
            dataWatcher.setObject(watcherObjectByte(id), value);

            return this;
        }

        @Override
        public Builder set(final int id, final Integer value) {
            dataWatcher.setObject(watcherObjectInteger(id), value);

            return this;
        }

        @Override
        public Builder set(final int id, final Float value) {
            dataWatcher.setObject(watcherObjectFloat(id), value);

            return this;
        }

        @Override
        public Builder set(final int id, final String value) {
            dataWatcher.setObject(watcherObjectString(id), value);

            return this;
        }

        @Override
        public Builder setIChatBaseComponent(final int id, final Object value) {
            dataWatcher.setObject(watcherObjectIChatBaseComponent(id), value);

            return this;
        }

        @Override
        public Builder setItemStack(int id, Object value) {
            dataWatcher.setObject(watcherObjectItemStack(id), value);

            return this;
        }

        @Override
        public Builder setOptionalIBlockData(final int id, final Optional<Object> value) {
            dataWatcher.setObject(watcherObjectOptionalIBlockData(id), value);

            return this;
        }

        @Override
        public Builder set(final int id, final Boolean value) {
            dataWatcher.setObject(watcherObjectBoolean(id), value);

            return this;
        }

        @Override
        public Builder setVector3f(final int id, final Object value) {
            dataWatcher.setObject(watcherObjectVector3f(id), value);

            return this;
        }

        @Override
        public Builder set(final int id, final BlockPosition value) {
            dataWatcher.setObject(watcherObjectBlockPosition(id), value);

            return this;
        }

        @Override
        public Builder set(final int id, final Optional<BlockPosition> value) {
            dataWatcher.setObject(watcherObjectOptionalBlockPosition(id), value);

            return this;
        }

        @Override
        public Builder setEnumDirection(final int id, final Object value) {
            dataWatcher.setObject(watcherObjectEnumDirection(id), value);

            return this;
        }

        @Override
        public Builder setOptionalUUID(final int id, final Object value) {
            dataWatcher.setObject(watcherObjectOptionalUUID(id), value);

            return this;
        }

        @Override
        public Builder setNBTTagCompound(final int id, final Object value) {
            dataWatcher.setObject(watcherObjectNBTTagCompound(id), value);

            return this;
        }

        @Override
        public Builder set(final int id, final Object value) {
            dataWatcher.setObject(watcherObjectObject(id), value);

            return this;
        }

        @Override
        public WrappedDataWatcher build() {
            return dataWatcher;
        }
    }
}
