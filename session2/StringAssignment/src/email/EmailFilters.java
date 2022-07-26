package email;

import java.util.*;

public class EmailFilters {

    private static final Long DEFAULT_OCCURRENCES_NO = 0L;
    private static final String EMPTY_STRING = "";
    private static final String EMAIL_PREFFIX = "@";
    private static final String DOT_COM = ".com";
    private static final Set<String> EMAIL_DOMAINS = new HashSet<>(Arrays.asList("@gmail.com", "@outlook.com", "@linkedin.com", "@gmail.com", "@gmail.com", "@outlook.com"));
    private final String[] emails = {
            "ramesh@gmail.com",
            "rakesh@outlook.com",
            "lokesh@linkedin.com",
            "mahesh@gmail.com",
            "ganesh@gmail.com",
            "rajesh@outlook.com"};
    private static Map<String, Long> map;

    static {
        map = new HashMap<>();
        EMAIL_DOMAINS.forEach(domain -> map.put(prepareDomain(domain), DEFAULT_OCCURRENCES_NO));
    }

    public Map<String, Long> countUsersByEmail() {
        for (String email : emails) {
            for (String domain : EMAIL_DOMAINS) {
                if (email.endsWith(domain)) {
                    map.put(prepareDomain(domain), map.get(prepareDomain(domain)) + 1L);
                    break;
                }
            }
        }
        return map;
    }

    private static String prepareDomain(String domain) {
        return domain
                .replace(EMAIL_PREFFIX, EMPTY_STRING)
                .replace(DOT_COM, EMPTY_STRING);
    }

    public static void main(String[] args) {
        EmailFilters emailFilters = new EmailFilters();
        Map<String, Long> map = emailFilters.countUsersByEmail();
        for(Map.Entry<String, Long> entry : map.entrySet()){
            System.out.println(entry.getKey() + " has " + entry.getValue() + " users");
        }
    }

    /*
     * Write the code to count the number of users in particular domain
     * for example
     * gmail has 3 users
     * outlook has 2 users
     * linkedin has 1 user
     *
     * HINT : use endsWith() of String class
     * */
}
