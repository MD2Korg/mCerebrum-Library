package org.md2k.mcerebrum.core.access.serverinfo;

// @formatter:off
import android.net.Uri;
import android.provider.BaseColumns;

import org.md2k.mcerebrum.core.access.SampleProvider;
import org.md2k.mcerebrum.core.access.base.AbstractSelection;
import org.md2k.mcerebrum.core.access.appinfo.AppInfoColumns;
import org.md2k.mcerebrum.core.access.configinfo.ConfigInfoColumns;
import org.md2k.mcerebrum.core.access.serverinfo.ServerInfoColumns;
import org.md2k.mcerebrum.core.access.studyinfo.StudyInfoColumns;
import org.md2k.mcerebrum.core.access.userinfo.UserInfoColumns;

/**
 * Server information
 */
@SuppressWarnings("unused")
public class ServerInfoColumns implements BaseColumns {
    public static final String TABLE_NAME = "server_info";
    public static final Uri CONTENT_URI = Uri.parse(SampleProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String SERVER_ADDRESS = "server_address";

    public static final String USERNAME = "username";

    public static final String UUID = "uuid";

    public static final String PASSWORD_HASH = "password_hash";

    public static final String TOKEN = "token";

    public static final String FILE_NAME = "file_name";

    public static final String CURRENT_VERSION = "current_version";

    public static final String LATEST_VERSION = "latest_version";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            SERVER_ADDRESS,
            USERNAME,
            UUID,
            PASSWORD_HASH,
            TOKEN,
            FILE_NAME,
            CURRENT_VERSION,
            LATEST_VERSION
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(SERVER_ADDRESS) || c.contains("." + SERVER_ADDRESS)) return true;
            if (c.equals(USERNAME) || c.contains("." + USERNAME)) return true;
            if (c.equals(UUID) || c.contains("." + UUID)) return true;
            if (c.equals(PASSWORD_HASH) || c.contains("." + PASSWORD_HASH)) return true;
            if (c.equals(TOKEN) || c.contains("." + TOKEN)) return true;
            if (c.equals(FILE_NAME) || c.contains("." + FILE_NAME)) return true;
            if (c.equals(CURRENT_VERSION) || c.contains("." + CURRENT_VERSION)) return true;
            if (c.equals(LATEST_VERSION) || c.contains("." + LATEST_VERSION)) return true;
        }
        return false;
    }

}