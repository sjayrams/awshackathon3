package com.hackathon;

/**
 * Created by guptga1 on 11/28/16.
 */
public class AAA {
    String country;
    String landscape;
    String lon;
    String lat;
    String ciaf;
    String access;
    String n;
    String k;
    String p;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLandscape() {
        return landscape;
    }

    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getCiaf() {
        return ciaf;
    }

    public void setCiaf(String ciaf) {
        this.ciaf = ciaf;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "AAA{" +
                "country='" + country + '\'' +
                ", landscape='" + landscape + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                ", ciaf='" + ciaf + '\'' +
                ", access='" + access + '\'' +
                ", n='" + n + '\'' +
                ", k='" + k + '\'' +
                ", p='" + p + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AAA)) return false;

        AAA aaa = (AAA) o;

        if (!getCountry().equals(aaa.getCountry())) return false;
        if (!getLandscape().equals(aaa.getLandscape())) return false;
        if (!getLon().equals(aaa.getLon())) return false;
        if (!getLat().equals(aaa.getLat())) return false;
        if (!getCiaf().equals(aaa.getCiaf())) return false;
        if (!getAccess().equals(aaa.getAccess())) return false;
        if (!getN().equals(aaa.getN())) return false;
        if (!getK().equals(aaa.getK())) return false;
        return getP().equals(aaa.getP());

    }

    @Override
    public int hashCode() {
        int result = getCountry().hashCode();
        result = 31 * result + getLandscape().hashCode();
        result = 31 * result + getLon().hashCode();
        result = 31 * result + getLat().hashCode();
        result = 31 * result + getCiaf().hashCode();
        result = 31 * result + getAccess().hashCode();
        result = 31 * result + getN().hashCode();
        result = 31 * result + getK().hashCode();
        result = 31 * result + getP().hashCode();
        return result;
    }
}
