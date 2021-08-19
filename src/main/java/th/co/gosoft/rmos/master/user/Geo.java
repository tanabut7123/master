
package th.co.gosoft.rmos.master.user;

import javax.persistence.*;

@Entity
public class Geo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="geo_id")
    private Long id;

    private String lat;
    private String lng;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
