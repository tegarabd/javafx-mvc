module MVC {
	exports controller;
	exports database;
	exports view;
	exports main;
	exports model;
	exports lib;

	requires transitive java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires transitive javafx.graphics;
}