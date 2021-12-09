module bg.tu_varna.sit.inventorymanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires log4j;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires java.sql;

    opens bg.tu_varna.sit.inventorymanagement.data.entities to org.hibernate.orm.core;
    exports bg.tu_varna.sit.inventorymanagement.data.entities;

    opens bg.tu_varna.sit.inventorymanagement.data.access to org.hibernate.orm.core;
    exports bg.tu_varna.sit.inventorymanagement.data.access;

    exports bg.tu_varna.sit.inventorymanagement.presentation.models;
    opens bg.tu_varna.sit.inventorymanagement.presentation.models to javafx.base;


    exports bg.tu_varna.sit.inventorymanagement.application;
    opens bg.tu_varna.sit.inventorymanagement.application to javafx.fxml;

    exports bg.tu_varna.sit.inventorymanagement.presentation.controllers;
    opens bg.tu_varna.sit.inventorymanagement.presentation.controllers to javafx.fxml;
}