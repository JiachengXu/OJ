/** 
 * Forward declaration of isBadVersion API.
 * @param   version   your guess about first bad version
 * @return 	 	      true if current version is bad 
 *			          false if current version is good
 * func isBadVersion(version int) bool;
 */

func firstBadVersion(n int) int {
    if n == 1 {
        return n
    }
    start, end := 1, n
    for start < end {
        middle := (end + start) / 2
        if isBadVersion(middle) {
            end = middle
        } else {
            start = middle + 1
        }
    }
    return end
}