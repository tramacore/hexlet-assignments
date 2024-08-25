package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {
    public static List<String> buildApartmentsList(List<Home> homeList, int n) {
        var list = homeList.stream().sorted(Comparator.comparing(Home::getArea)).limit(n).toList();
        List<String> answer = new ArrayList<>();
        if (homeList.size() == 0) {
            return answer;
        } else {
            for (int i = 0; i < n; i++) {
                answer.add(list.get(i).toString());
            }
            return answer;
        }
    }
}
