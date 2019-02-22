/**
 *
 */


import java.util.*;
import java.util.stream.*;

class VisitCounter {

    class UserStats {
        Optional<Long> visitCount;

        public Optional<Long> getVisitCount() {
            return visitCount;
        }

        public void setVisitCount(Optional<Long> visitCount) {
            this.visitCount = visitCount;
        }
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
}