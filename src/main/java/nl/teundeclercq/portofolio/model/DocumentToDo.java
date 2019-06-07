package nl.teundeclercq.portofolio.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class DocumentToDo {
    private int id;
    private String name;
    private String data;
    private Portfolio portfolio;
    private Set<Admin> admins;
}
