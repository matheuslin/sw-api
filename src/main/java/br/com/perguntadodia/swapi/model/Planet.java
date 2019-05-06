package br.com.perguntadodia.swapi.model;

public class Planet{
    private Integer id;
    private Integer swid;
    private String name;
    private String climate;
    private String terrain;
    private Integer filmCount;

    public Planet(){

    }

    public Planet(Integer id, String name){
        this.setId(id);
        this.setName(name);
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the swid
     */
    public Integer getSwid() {
        return swid;
    }

    /**
     * @param swid the swid to set
     */
    public void setSwid(Integer swid) {
        this.swid = swid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the climate
     */
    public String getClimate() {
        return climate;
    }

    /**
     * @param climate the climate to set
     */
    public void setClimate(String climate) {
        this.climate = climate;
    }

    /**
     * @return the terrain
     */
    public String getTerrain() {
        return terrain;
    }

    /**
     * @param terrain the terrain to set
     */
    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    /**
     * @return the filmCount
     */
    public Integer getFilmCount() {
        return filmCount;
    }

    /**
     * @param filmCount the filmCount to set
     */
    public void setFilmCount(Integer filmCount) {
        this.filmCount = filmCount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((swid == null) ? 0 : swid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Planet other = (Planet) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (swid == null) {
            if (other.swid != null)
                return false;
        } else if (!swid.equals(other.swid))
            return false;
        return true;
    }
}