package org.md2k.mcerebrum.core.access.studyinfo;

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
 * Study Information
 */
@SuppressWarnings("unused")
public class StudyInfoColumns implements BaseColumns {
    public static final String TABLE_NAME = "study_info";
    public static final Uri CONTENT_URI = Uri.parse(SampleProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String SID = "sid";

    public static final String TYPE = "type";

    public static final String TITLE = "title";

    public static final String SUMMARY = "summary";

    public static final String DESCRIPTION = "description";

    public static final String VERSION = "version";

    public static final String ICON = "icon";

    public static final String COVER_IMAGE = "cover_image";

    public static final String START_AT_BOOT = "start_at_boot";

    public static final String STARTED = "started";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." + SID;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            SID,
            TYPE,
            TITLE,
            SUMMARY,
            DESCRIPTION,
            VERSION,
            ICON,
            COVER_IMAGE,
            START_AT_BOOT,
            STARTED
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(SID) || c.contains("." + SID)) return true;
            if (c.equals(TYPE) || c.contains("." + TYPE)) return true;
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(SUMMARY) || c.contains("." + SUMMARY)) return true;
            if (c.equals(DESCRIPTION) || c.contains("." + DESCRIPTION)) return true;
            if (c.equals(VERSION) || c.contains("." + VERSION)) return true;
            if (c.equals(ICON) || c.contains("." + ICON)) return true;
            if (c.equals(COVER_IMAGE) || c.contains("." + COVER_IMAGE)) return true;
            if (c.equals(START_AT_BOOT) || c.contains("." + START_AT_BOOT)) return true;
            if (c.equals(STARTED) || c.contains("." + STARTED)) return true;
        }
        return false;
    }

}