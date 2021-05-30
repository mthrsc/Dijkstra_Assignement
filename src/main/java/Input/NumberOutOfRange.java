package Input;

/**
 *
 * @author Matthieu Roscio
 * NumberOutOfRange.java
 * 18 11 2020
 */
class NumberOutOfRange extends Exception {

    public NumberOutOfRange() {
    }

    public String getMessage() {
        String s = "NEGATIVE NUMBER not allowed, please re-enter value";
        return s;
    }
}
