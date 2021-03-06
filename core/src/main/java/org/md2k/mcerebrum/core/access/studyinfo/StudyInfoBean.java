package org.md2k.mcerebrum.core.access.studyinfo;

// @formatter:off
import org.md2k.mcerebrum.core.access.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Study ContentProvider Bean class.
 * This class is auto-generated by Android ContentProvider Generator.
 * For more information see <a href="https://github.com/BoD/android-contentprovider-generator">GitHub</a>.
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class StudyInfoBean implements StudyInfoModel {
    private long mId;
    private String mSid;
    private String mType;
    private String mTitle;
    private String mSummary;
    private String mDescription;
    private String mVersion;
    private String mIcon;
    private String mCoverImage;
    private Boolean mStartAtBoot;
    private Boolean mStarted;

    @Override
    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    @Nullable
    @Override
    public String getSid() {
        return mSid;
    }

    public void setSid(@Nullable String sid) {
        mSid = sid;
    }

    @Nullable
    @Override
    public String getType() {
        return mType;
    }

    public void setType(@Nullable String type) {
        mType = type;
    }

    @Nullable
    @Override
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(@Nullable String title) {
        mTitle = title;
    }

    @Nullable
    @Override
    public String getSummary() {
        return mSummary;
    }

    public void setSummary(@Nullable String summary) {
        mSummary = summary;
    }

    @Nullable
    @Override
    public String getDescription() {
        return mDescription;
    }

    public void setDescription(@Nullable String description) {
        mDescription = description;
    }

    @Nullable
    @Override
    public String getVersion() {
        return mVersion;
    }

    public void setVersion(@Nullable String version) {
        mVersion = version;
    }

    @Nullable
    @Override
    public String getIcon() {
        return mIcon;
    }

    public void setIcon(@Nullable String icon) {
        mIcon = icon;
    }

    @Nullable
    @Override
    public String getCoverImage() {
        return mCoverImage;
    }

    public void setCoverImage(@Nullable String coverImage) {
        mCoverImage = coverImage;
    }

    @Nullable
    @Override
    public Boolean getStartAtBoot() {
        return mStartAtBoot;
    }

    public void setStartAtBoot(@Nullable Boolean startAtBoot) {
        mStartAtBoot = startAtBoot;
    }

    @Nullable
    @Override
    public Boolean getStarted() {
        return mStarted;
    }

    public void setStarted(@Nullable Boolean started) {
        mStarted = started;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudyInfoBean bean = (StudyInfoBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    @NonNull
    public static StudyInfoBean newInstance(long id, @Nullable String sid, @Nullable String type, @Nullable String title, @Nullable String summary, @Nullable String description, @Nullable String version, @Nullable String icon, @Nullable String coverImage, @Nullable Boolean startAtBoot, @Nullable Boolean started) {
        StudyInfoBean res = new StudyInfoBean();
        res.mId = id;
        res.mSid = sid;
        res.mType = type;
        res.mTitle = title;
        res.mSummary = summary;
        res.mDescription = description;
        res.mVersion = version;
        res.mIcon = icon;
        res.mCoverImage = coverImage;
        res.mStartAtBoot = startAtBoot;
        res.mStarted = started;
        return res;
    }

    @NonNull
    public static StudyInfoBean copy(@NonNull StudyInfoModel from) {
        StudyInfoBean res = new StudyInfoBean();
        res.mId = from.getId();
        res.mSid = from.getSid();
        res.mType = from.getType();
        res.mTitle = from.getTitle();
        res.mSummary = from.getSummary();
        res.mDescription = from.getDescription();
        res.mVersion = from.getVersion();
        res.mIcon = from.getIcon();
        res.mCoverImage = from.getCoverImage();
        res.mStartAtBoot = from.getStartAtBoot();
        res.mStarted = from.getStarted();
        return res;
    }

    public static class Builder {
        private StudyInfoBean mRes = new StudyInfoBean();

        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        public Builder sid(@Nullable String sid) {
            mRes.mSid = sid;
            return this;
        }

        public Builder type(@Nullable String type) {
            mRes.mType = type;
            return this;
        }

        public Builder title(@Nullable String title) {
            mRes.mTitle = title;
            return this;
        }

        public Builder summary(@Nullable String summary) {
            mRes.mSummary = summary;
            return this;
        }

        public Builder description(@Nullable String description) {
            mRes.mDescription = description;
            return this;
        }

        public Builder version(@Nullable String version) {
            mRes.mVersion = version;
            return this;
        }

        public Builder icon(@Nullable String icon) {
            mRes.mIcon = icon;
            return this;
        }

        public Builder coverImage(@Nullable String coverImage) {
            mRes.mCoverImage = coverImage;
            return this;
        }

        public Builder startAtBoot(@Nullable Boolean startAtBoot) {
            mRes.mStartAtBoot = startAtBoot;
            return this;
        }

        public Builder started(@Nullable Boolean started) {
            mRes.mStarted = started;
            return this;
        }

        public StudyInfoBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
