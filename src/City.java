public class City {
    private String tableName;
    private String tableRegion;
    private String tableDistrict;
    private String tablePopulation;
    private String tableFoundation;
    public City(String tableName,String tableRegion,String tableDistrict,String tablePopulation,String tableFoundation){
        this.tableName = tableName;
        this.tableRegion = tableRegion;
        this.tableDistrict = tableDistrict;
        this.tablePopulation = tablePopulation;
        this.tableFoundation = tableFoundation;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableRegion() {
        return tableRegion;
    }

    public void setTableRegion(String tableRegion) {
        this.tableRegion = tableRegion;
    }

    public String getTableDistrict() {
        return tableDistrict;
    }

    public void setTableDistrict(String tableDistrict) {
        this.tableDistrict = tableDistrict;
    }

    public String getTablePopulation() {
        return tablePopulation;
    }

    public void setTablePopulation(String tablePopulation) {
        this.tablePopulation = tablePopulation;
    }

    @Override
    public String toString() {
        String string = "City{name='" + tableName + "', region='" + tableRegion + "', district='" + tableDistrict + "', population=" + tablePopulation + ", foundation='" + tableFoundation + "'}";
        return string;
    }

}
