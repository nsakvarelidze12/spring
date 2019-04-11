package pak.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("spelBean")
public class SpelBean {

    @Value("property")
    private String prefix;
    // SpEL expression. it starts with a hash (#) symbol and is wrapped with braces
    @Value("#{spelBean.getPrefix().concat(' value')}")
    private String property;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getPrefix() {
        return prefix;
    }

}
