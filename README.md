# MyEssentialsLib-Java

Biblioteca com métodos e utilidades recorrentes em meus projetos Java.

## Contém

### Hibernate

- HibernateUtil.java - Classe utilitária padrão do hibernate;
- GenericHibernateDaoInterface.java - Interface do Dao Genérico do Hibernate;
- GenericHibernateDao.java - Classe Dao genérica usando somente hibernate;

### JPA com Hibernate

- EntityBase - Uma interface que deve ser implementada pelas entidades;
- GenericJpaDao - Um DAO genérico que deverá ser extendido pelos DAOs comuns;
- Util - Uma clase com metodos diversos usados no dia-a-dia;

## Dependências

- Hibernate 4.3.x
- Persistence (JPA-2.1)
- Jandex-1.1.x
