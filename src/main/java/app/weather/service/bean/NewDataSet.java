package app.weather.service.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class NewDataSet
{
    private Table[] Table;

    public Table[] getTable ()
    {
        return Table;
    }

    public void setTable (Table[] Table)
    {
        this.Table = Table;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Table = "+Table+"]";
    }
}