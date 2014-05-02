package data.ws.config;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Stateless
@XmlRootElement(name="config")
public class Config implements Serializable {
    
    private int pageSize;
    private String paramSeparator;
    private String linkPreviousName;
    private String linkNextName;
    
    public Config () { }
    
    @XmlElement
    public int getPageSize () {
        return this.pageSize;
    }
    
    public void setPageSize (int pageSize) {
        this.pageSize = pageSize;
    }

    @XmlElement
    public String getParamSeparator() {
        return paramSeparator;
    }

    public void setParamSeparator(String paramSeparator) {
        this.paramSeparator = paramSeparator;
    }

    @XmlElement
    public String getLinkPreviousName() {
        return linkPreviousName;
    }

    public void setLinkPreviousName(String linkPreviousName) {
        this.linkPreviousName = linkPreviousName;
    }

    @XmlElement
    public String getLinkNextName() {
        return linkNextName;
    }

    public void setLinkNextName(String linkNextName) {
        this.linkNextName = linkNextName;
    }
}
