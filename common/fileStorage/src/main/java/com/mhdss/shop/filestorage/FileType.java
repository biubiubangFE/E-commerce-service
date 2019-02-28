package com.mhdss.shop.filestorage;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

public enum FileType {

    JPEG((byte) 1, "jpeg", "jpeg"),
    DCM((byte) 2, "dcm", "dcm"),
    DOC((byte) 3, "doc", "doc"),
    TMP((byte) 4, "tmp", ""),
    JSON((byte) 5, "json", "json"),
    XML((byte) 6, "xml", "xml"),
    MGJSON((byte) 7, "mgjson", "mgjson"),
    ZIP((byte) 8, "zip", "zip"),
    OTHER((byte) 0, "oth", ""),
    BIN((byte) 9, "bin", "bin"),
    HTML((byte) 10, "html", "html"),
    NII_GZ((byte) 11, "nii-gz", "nii.gz"),
    XLSX((byte) 12, "xlsx", "xlsx"),
    
    alg_run((byte) 50, "alg-run", ""),
    algorithm_platform01((byte) 51, "algorithm-platform01", ""),
    algorithm_platform02((byte) 52, "algorithm-platform02", ""),
    archive_zip_file((byte) 53, "archive-zip-file", ""),
    dicom_partner((byte) 54, "dicom-partner", ""),
    dicom_repo((byte) 55, "dicom-repo", ""),
    dicom_worker_archive((byte) 56, "dicom-worker-archive", ""),
    passport((byte) 57, "passport", ""),
    rtcloud_platform02_prod((byte) 58, "rtcloud-platform02-prod", ""),
    algorithm_platform_temp((byte) 59, "algorithm-platform-temp", ""),
    contouing_repo_test((byte) 60, "contouing-repo-test", ""),
    contouring_platform01((byte) 61, "contouring-platform01", ""),
    dcm2nii_repo((byte) 62, "dcm2nii-repo", ""),
    dicom_repo_pre((byte) 63, "dicom-repo-pre", ""),
    dicom_repo_test((byte) 64, "dicom-repo-test", ""),
    nii2dcm_repo((byte) 65, "nii2dcm-repo", ""),
    rtcloud_platform01((byte) 66, "rtcloud-platform01", ""),
    rtcloud_platform02((byte) 67, "rtcloud-platform02", ""),
    rtcloud_platform02_dev((byte) 68, "rtcloud-platform02-dev", ""),
    rtcloud_platform02_pre_release((byte) 69, "rtcloud-platform02-pre-release", ""),
    rtcloud_platform02_test((byte) 70, "rtcloud-platform02-test", ""),
    test((byte) 71, "test", ""),
    test_bucket((byte) 72, "test-bucket", ""),
    viewer_platform01((byte) 73, "viewer-platform01", ""),
    viewer_platform01_test((byte) 74, "viewer-platform01-test", ""),

    ERROR((byte) -1, "", "");

    private final byte code;
    private final String name;
    private final String ext;

    FileType(final byte code, final String name, final String ext) {
        this.code = code;
        this.name = name;
        this.ext = ext;
    }

    public static FileType resolveJSONType(FileType type, String filePath) {
        if (JSON == type || MGJSON == type) {
            return type;
        } else {
            FileType resolvedType = FileType.getTypeByExt(FilenameUtils.getExtension(filePath));
            if (JSON == resolvedType || MGJSON == resolvedType) {
                return resolvedType;
            } else {
                throw new StorageException("file type error");
            }
        }
    }

    /**
     * GET时检查
     */
    public static boolean checkTypeIsJSONType(FileType type, String filePath) {
        return checkTypeIsJSONType(type) || checkTypeIsJSONType(FileType.getTypeByExt(FilenameUtils.getExtension(filePath)));
    }

    /**
     * PUT时检查
     */
    public static boolean checkTypeIsJSONType(FileType type) {
        return type != null
                && (type == FileType.JSON || type == FileType.MGJSON);
    }

    public static FileType getType(byte c) {
        for (FileType t : FileType.values()) {
            if (t.code == c) {
                return t;
            }
        }
        return FileType.OTHER;
    }

    public static FileType getType(String name) {
        for (FileType t : FileType.values()) {
            if (StringUtils.equals(t.name, name)) {
                return t;
            }
        }
        return FileType.OTHER;
    }

    public static FileType getTypeByExt(String ext) {
        for (FileType t : FileType.values()) {
            if (StringUtils.equalsIgnoreCase(t.ext, ext)) {
                return t;
            }
        }
        return FileType.OTHER;
    }

    public byte getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getExt() {
        return ext;
    }
}
