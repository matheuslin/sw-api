package br.com.perguntadodia.swapi.model;

import java.util.UUID;

public class Planet{
    private UUID id;
    private String swid;
    private String name;
    private String climate;
    private String terrain;
    private Integer filmCount;

    public Planet(){
        this.id = UUID.randomUUID();
    }

    public static Planet clonePlanet(Planet p){

        Planet copy = new Planet();

        // copy other properties
        copy.swid = p.swid;
        copy.name = p.name;
        copy.climate = p.climate;
        copy.terrain = p.terrain;
        copy.filmCount = p.filmCount;

        return copy;
    }

    public static Planet fromSWPlanet(SWPlanet swplanet){
        Planet p = new Planet();
        p.swid = swplanet.getId();
        p.name = swplanet.getName();
        p.climate = swplanet.getClimate();
        p.terrain = swplanet.getTerrain();
        p.filmCount = swplanet.getFilms().size();

        return p;
    }

    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @return the swid
     */
    public String getSwid() {
        return swid;
    }

    /**
     * @param swid the swid to set
     */
    public void setSwid(String swid) {
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

    @Override
    public String toString() {
        return "Planet [climate=" + climate + ", filmCount=" + filmCount + ", id=" + id + ", name=" + name + ", swid="
                + swid + ", terrain=" + terrain + "]";
    }
}