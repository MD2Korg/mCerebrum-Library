package org.md2k.mcerebrum.core.access.configinfo;

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
 * Config ContentProvider ContentValues class.
 * This class is auto-generated by Android ContentProvider Generator.
 * For more information see <a href="https://github.com/BoD/android-contentprovider-generator">GitHub</a>.
 */
@SuppressWarnings("unused")
public class ConfigInfoColumns implements BaseColumns {
    public static final String TABLE_NAME = "config_info";
    public static final Uri CONTENT_URI = Uri.parse(SampleProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    public static final String _ID = BaseColumns._ID;

    public static final String CID = "cid";

    public static final String TYPE = "type";

    public static final String TITLE = "title";

    public static final String SUMMARY = "summary";

    public static final String DESCRIPTION = "description";

    public static final String VERSIONS = "versions";

    public static final String UPDATES = "updates";

    public static final String EXPECTED_VERSION = "expected_version";

    public static final String LATEST_VERSION = "latest_version";

    public static final String DOWNLOAD_FROM = "download_from";

    public static final String DOWNLOAD_LINK = "download_link";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            CID,
            TYPE,
            TITLE,
            SUMMARY,
            DESCRIPTION,
            VERSIONS,
            UPDATES,
            EXPECTED_VERSION,
            LATEST_VERSION,
            DOWNLOAD_FROM,
            DOWNLOAD_LINK
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(CID) || c.contains("." + CID)) return true;
            if (c.equals(TYPE) || c.contains("." + TYPE)) return true;
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(SUMMARY) || c.contains("." + SUMMARY)) return true;
            if (c.equals(DESCRIPTION) || c.contains("." + DESCRIPTION)) return true;
            if (c.equals(VERSIONS) || c.contains("." + VERSIONS)) return true;
            if (c.equals(UPDATES) || c.contains("." + UPDATES)) return true;
            if (c.equals(EXPECTED_VERSION) || c.contains("." + EXPECTED_VERSION)) return true;
            if (c.equals(LATEST_VERSION) || c.contains("." + LATEST_VERSION)) return true;
            if (c.equals(DOWNLOAD_FROM) || c.contains("." + DOWNLOAD_FROM)) return true;
            if (c.equals(DOWNLOAD_LINK) || c.contains("." + DOWNLOAD_LINK)) return true;
        }
        return false;
    }

}
