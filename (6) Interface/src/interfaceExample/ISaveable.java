package interfaceExample;

import java.util.ArrayList;
import java.util.List;

public interface ISaveable {
    List<String> write();
    void read(List<String> savedValues);

}
