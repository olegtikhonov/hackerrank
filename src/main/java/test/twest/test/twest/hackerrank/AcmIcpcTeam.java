package test.twest.test.twest.hackerrank;


/**
 * There are a number of people who will be attending ACM-ICPC World Finals. Each of them may be well versed in a number
 * of topics. Given a list of topics known by each attendee, you must determine the maximum number of topics a 2-person
 * team can know. Also find out how many ways a team can be formed to know that many topics. Lists will be in the form of
 * bit strings, where each string represents an attendee and each position in that string represents a field of knowledge,
 * 1 if its a known field or 0 if not.
 */
public class AcmIcpcTeam {

    public static int[] acmTeam(String[] topic) {
        int topicsMax = -1, teams = 0, count;

        for(int j = 0; j < topic.length; j++) {
            for(int k = j + 1; k < topic.length; k++) {
                count = 0;

                for(int i = 0; i < topic[k].length(); i++) {
                    if((topic[k].charAt(i) != topic[j].charAt(i)) || (topic[k].charAt(i) == '1' && topic[j].charAt(i) == '1')) {
                        count++;
                    }
                }

                if(count > topicsMax) {
                    topicsMax = count;
                    teams = 1;
                } else if(count == topicsMax) {
                    teams++;

                }
            }
        }

        return new int[]{topicsMax, teams};
    }
}
