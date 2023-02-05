package com.apollo.leetcode.medium;

/**
 * 1344. Angle Between Hands of a Clock
 * <p>
 * Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.
 * Answers within 10-5 of the actual value will be accepted as correct.
 *
 * @see <a href="https://leetcode.com/problems/angle-between-hands-of-a-clock/">Angle Between Hands of a Clock<a/>
 */
public class AngleBetweenHandsOfAClock {

    private static final double ANGLE_PER_HOUR = (double) 360 / 12;
    private static final double ANGLE_PER_MINUTE = (double) 360 / 60;
    private static final double MINUTES_PER_HOUR = 60;


    public double angleClock(int hour, int minutes) {
        if (hour == 12) hour = 0;
        if (minutes == 60) minutes = 0;

        double mAngle = minutes * ANGLE_PER_MINUTE;
        double hAngle = (hour + minutes / MINUTES_PER_HOUR) * ANGLE_PER_HOUR;
        double angle = Math.abs(hAngle - mAngle);
        return angle >= 180 ? 360 - angle : angle;
    }

}
