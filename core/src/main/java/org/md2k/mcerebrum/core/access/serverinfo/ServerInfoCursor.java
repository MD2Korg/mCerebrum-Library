package org.md2k.mcerebrum.core.access.serverinfo;

// @formatter:off
import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.md2k.mcerebrum.core.access.base.AbstractCursor;

/**
 * Sever ContentProvider Cursor class.
 * This class is auto-generated by Android ContentProvider Generator.
 * For more information see <a href="https://github.com/BoD/android-contentprovider-generator">GitHub</a>.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class ServerInfoCursor extends AbstractCursor implements ServerInfoModel {
    public ServerInfoCursor(Cursor cursor) {
        super(cursor);
    }

    @Override
    public long getId() {
        Long res = getLongOrNull(ServerInfoColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    @Nullable
    @Override
    public String getServerAddress() {
        String res = getStringOrNull(ServerInfoColumns.SERVER_ADDRESS);
        return res;
    }

    @Nullable
    @Override
    public String getUsername() {
        String res = getStringOrNull(ServerInfoColumns.USERNAME);
        return res;
    }

    @Nullable
    @Override
    public String getUuid() {
        String res = getStringOrNull(ServerInfoColumns.UUID);
        return res;
    }

    @Nullable
    @Override
    public String getPasswordHash() {
        String res = getStringOrNull(ServerInfoColumns.PASSWORD_HASH);
        return res;
    }

    @Nullable
    @Override
    public String getToken() {
        String res = getStringOrNull(ServerInfoColumns.TOKEN);
        return res;
    }

    @Nullable
    @Override
    public String getFileName() {
        String res = getStringOrNull(ServerInfoColumns.FILE_NAME);
        return res;
    }

    @Nullable
    @Override
    public String getCurrentVersion() {
        String res = getStringOrNull(ServerInfoColumns.CURRENT_VERSION);
        return res;
    }

    @Nullable
    @Override
    public String getLatestVersion() {
        String res = getStringOrNull(ServerInfoColumns.LATEST_VERSION);
        return res;
    }
}
