package com.company;
import java.util.*;

public class Vertex {
    private String vertex;

    public Vertex(String vertex) {
        this.vertex = vertex;
    }

    public String getLabel() {
        return vertex;
    }

    public void setLabel(String vertex) {
        this.vertex = vertex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return vertex.equals(vertex.vertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex);
    }
}
