/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

class ArchUnitTests {
  JavaClasses importedClasses = new ClassFileImporter()
          .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
          .importPackages("com.duberlyguarnizo.accountinquireservice");

  @Test
  @DisplayName("Domain Models should not be Entities and should reside in domain")
  void domainModelClassesShouldBeInDomainModelPackage() {
    ArchRule rule = classes().that().areAnnotatedWith(DomainModel.class).should().bePublic()
            .andShould().notBeAnnotatedWith("Entity")
            .andShould().resideInAPackage("..domain.model");
    rule.check(importedClasses);
  }

  @Test
  @DisplayName("Database repositories should be annotated with Repository and reside in infrastructure")
  void RepositoriesShouldBeInInfrastructurePackage() {
    ArchRule rule = classes().that().areAnnotatedWith(Repository.class).should().resideInAPackage("..infrastructure.persistence..");
    rule.check(importedClasses);
  }

  @Test
  @DisplayName("Database Entities should be annotated with Document and reside in infrastructure")
  void DocumentsShouldBeInInfrastructurePackage() {
    ArchRule rule = classes().that().areAnnotatedWith(Document.class).should().haveSimpleNameContaining("Entity").andShould().resideInAPackage("..infrastructure.persistence..");
    rule.check(importedClasses);
  }

}
