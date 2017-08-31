import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

//
//Unused class!
//

public class Element {

    @JsonIgnore
    public Integer value;

    /**
    @JsonCreator
    public Element (@JsonProperty ("element") Integer value) {
        this.value = value;
    }
    */

    @JsonValue
    public Integer toInt () {
        return this.value;
    }
}
