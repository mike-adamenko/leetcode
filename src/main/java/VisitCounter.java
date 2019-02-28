/**
 *
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class VisitCounter {

    static class UserStats {
        Optional<Long> visitCount;

        UserStats(Long visitCount){
            this.visitCount = Optional.ofNullable(visitCount);
        }
        public Optional<Long> getVisitCount() {
            return visitCount;
        }

        public void setVisitCount(Optional<Long> visitCount) {
            this.visitCount = visitCount;
        }
    }

    public static void main(String[] args) {
        VisitCounter visitCounter = new VisitCounter();
        UserStats us1 = new UserStats(1L);
        UserStats us2 = new UserStats(2L);
        UserStats us3 = new UserStats(3L);
        UserStats usEmpty = new UserStats(null);

        Map<String, UserStats> userStatsMap1 = new HashMap<>();
        Map<String, UserStats> userStatsMap2 = new HashMap<>();
        userStatsMap1.put("1", us1);
        userStatsMap1.put("sdgfsdg", us2);
        userStatsMap2.put("1", us3);
        userStatsMap2.put("4", usEmpty);
        userStatsMap2.put("4", null);
        Map<String, UserStats>[] visits = new HashMap[2];
        visits[0] = userStatsMap1;
        visits[1] = userStatsMap2;

        System.out.println(visitCounter.count(visits));
    }

    Map<Long, Long> count(Map<String, UserStats>... visits) {
        Map<Long, Long> result = new HashMap<>();
        if (visits != null) {

            for (Map<String, UserStats> map : visits) {
                if (map != null) {
                    for (Map.Entry<String, UserStats> entry : map.entrySet()) {
                        try {
                            Long id = Long.parseLong(entry.getKey());
                            if (entry.getValue() != null && entry.getValue().getVisitCount().isPresent()) {
                                if (result.get(id) != null)
                                    result.put(id, result.get(id) + entry.getValue().getVisitCount().get());
                                else result.put(id, entry.getValue().getVisitCount().get());

                            }
                        } catch (NumberFormatException nfe) {}

                    }

                }
            }
        }

        return result;
    }

//    Map<Long, Long> countJava8(Map<String, UserStats>... visits) {
//        Map<Long, Long> result = new HashMap<>();
//
//            Optional.of(visits).
//                    map(arr -> Arrays.stream(arr).filter(map -> map != null).forEach(map -> map.entrySet().stream().
//                            map(entry -> {
//                                try {
//                                    Long id = Long.parseLong(entry.getKey());
//
//                                    result.putIfAbsent(id,Optional.ofNullable(entry.getValue()).map(userStats -> userStats.getVisitCount()).get().get() );
//                                } catch (NumberFormatException nfe) {}
//                            })));
//
//
//
////            Arrays.stream(visits).filter(stringUserStatsMap -> stringUserStatsMap != null).forEach(stringUserStatsMap ->
////                    stringUserStatsMap.entrySet().stream().filter(stringUserStatsEntry -> stringUserStatsEntry.getValue()!= null && stringUserStatsEntry.getValue().getVisitCount().ifPresent(); != Optional.empty())));
//        return result;
//    }
}