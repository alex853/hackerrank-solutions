package lt.problem_1152_analyze_user_website_visit_pattern_medium;

import java.util.*;

public class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // dictionary username -> user info
        // user info is a list of all 3 sequencies
        // we take next row of our log data
        // username gives us user info
        // we take website
        // if there is 0 or 1 3-sequence of length below 3 - we just add it to the 3-seq
        // else
        //     home, cart, maps    +     home
        //              ||
        //              \/
        //     home, cart, maps
        //     home, cart + home
        //     home, maps + home
        //     cart, maps + home
        // it consists of a problem to find all combinations 2 from 3
        // stats dictionary 3-seq -> set of users
        // we build it during all that iterations
        // then we need to iterate throw the stats and count visits
        // find 3-seqs with max
        // return it


        int length = username.length;
        Visit[] visits = new Visit[length];
        for (int i = 0; i < length; i++) {
            visits[i] = new Visit(username[i], timestamp[i], website[i]);
        }
        Arrays.sort(visits, Comparator.comparingInt(v -> v.timestamp));

        Map<String, UserInfo> userInfos = new TreeMap<>();
        Map<Seq, Set<String>> stats = new TreeMap<>();

        int[] maxVisits = new int[1];
        Set<Seq> maxVisitsSeqs = new TreeSet<>();

        for (Visit visit : visits) {
            final String eachUsername = visit.username;
            final String eachWebsite = visit.website;

            UserInfo userInfo = userInfos.computeIfAbsent(eachUsername, un -> new UserInfo(un));
            userInfo.onWebsiteVisited(eachWebsite, seq -> {
                Set<String> usersVisited = stats.computeIfAbsent(seq, s -> new TreeSet<>());
                usersVisited.add(eachUsername);

                int currVisits = usersVisited.size();
                if (currVisits > maxVisits[0]) {
                    maxVisits[0] = currVisits;
                    maxVisitsSeqs.clear();
                    maxVisitsSeqs.add(seq);
                } else if (currVisits == maxVisits[0]) {
                    maxVisitsSeqs.add(seq);
                }
            });
        }

        return maxVisitsSeqs.iterator().next().getWebsites();
    }

    private interface SeqVisitor {
        void visit(Seq seq);
    }

    private static class Visit {
        String username;
        int timestamp;
        String website;

        Visit(String username, int timestamp, String website) {
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    private static class UserInfo {
        private String username;
        private Set<Seq> seqs = new TreeSet<>();

        UserInfo(String username) {
            this.username = username;
        }

        void onWebsiteVisited(String website, SeqVisitor visitor) {
            if (seqs.size() == 0) {
                Seq seq = new Seq(website);
                seqs.add(seq);
                return;
            }

            Seq firstSeq = seqs.iterator().next();
            if (seqs.size() == 1 && !firstSeq.isReady()) {
                firstSeq.add(website);
                if (firstSeq.isReady()) {
                    visitor.visit(firstSeq);
                }
                return;
            }

            Set<Seq> newSeqs = new TreeSet<>();
            for (Seq seq : seqs) {
                List<String> websites = seq.getWebsites();
                for (int i = 0; i < websites.size(); i++) {
                    List<String> newWebsites = new ArrayList<>(websites);
                    newWebsites.remove(i);
                    newWebsites.add(website);

                    Seq newSeq = new Seq(newWebsites);
                    newSeqs.add(newSeq);
                    visitor.visit(newSeq);
                }
            }
            seqs.addAll(newSeqs);
        }
    }

    private static class Seq implements Comparable<Seq> {
        private List<String> websites = new ArrayList<>();

        Seq(String website) {
            add(website);
        }

        Seq(List<String> websites) {
            this.websites.addAll(websites);
        }

        void add(String website) {
            websites.add(website);
        }

        boolean isReady() {
            return websites.size() == 3;
        }

        List<String> getWebsites() {
            return Collections.unmodifiableList(websites);
        }

        @Override
        public int compareTo(Seq anotherSeq) {
            if (websites.size() != anotherSeq.websites.size()) {
                return websites.size() - anotherSeq.websites.size();
            }

            for (int i = 0; i < websites.size(); i++) {
                String w1 = websites.get(i);
                String w2 = anotherSeq.websites.get(i);

                int r = w1.compareTo(w2);
                if (r != 0) {
                    return r;
                }
            }

            return 0;
        }
    }
}