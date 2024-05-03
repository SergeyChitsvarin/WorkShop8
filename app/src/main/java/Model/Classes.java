package Model;

public class Classes {
    private String classId;
    private String className;
    private String classDesc;

    private static final int MAX_CLASS_NAME_LENGTH = 20;
    private static final int MAX_CLASS_DESC_LENGTH = 50;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        validateClassNameLength(className);
        this.className = className;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        validateClassDescLength(classDesc);
        this.classDesc = classDesc;
    }

    // Method to validate class name length
    private void validateClassNameLength(String className) {
        if (className != null && className.length() > MAX_CLASS_NAME_LENGTH) {
            throw new IllegalArgumentException("Class name length exceeds maximum length");
        }
    }

    // Method to validate class description length
    private void validateClassDescLength(String classDesc) {
        if (classDesc != null && classDesc.length() > MAX_CLASS_DESC_LENGTH) {
            throw new IllegalArgumentException("Class description length exceeds maximum length");
        }
    }

    // toString() method
    @Override
    public String toString() {
        return "TravelClass{" +
                "classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                ", classDesc='" + classDesc + '\'' +
                '}';
    }
}
