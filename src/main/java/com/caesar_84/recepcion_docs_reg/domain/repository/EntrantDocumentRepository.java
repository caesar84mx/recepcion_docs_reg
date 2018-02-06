package com.caesar_84.recepcion_docs_reg.domain.repository;

import com.caesar_84.recepcion_docs_reg.domain.HibernateUtil;
import com.caesar_84.recepcion_docs_reg.domain.model.EntrantDocument;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class EntrantDocumentRepository {
    private EntrantDocumentRepository() {}

    private static EntrantDocumentRepository instance = null;

    public EntrantDocument get(int id) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM EntrantDocument d WHERE d.id = :id");
        query.setParameter("id", id);
        EntrantDocument document = (EntrantDocument) query.getSingleResult();
        session.getTransaction().commit();
        session.close();

        return document;
    }

    public void save(EntrantDocument entrantDocument) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        session.save(entrantDocument);
        session.getTransaction().commit();
        session.close();
    }

    public void update(EntrantDocument entrantDocument) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        session.update(entrantDocument);
        session.getTransaction().commit();
        session.close();

    }

    public void delete(int id) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        EntrantDocument document = session.load(EntrantDocument.class, id);
        session.delete(document);
        session.getTransaction().commit();
        session.close();

    }

    @SuppressWarnings(value = "unchecked")
    public List<EntrantDocument> getAll() {
        List<EntrantDocument> list = new ArrayList<>();

        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        list = session.createQuery("FROM EntrantDocument d ORDER BY d.timeHanded DESC").list();
        session.getTransaction().commit();
        session.close();

        return list;
    }

    public static EntrantDocumentRepository getInstance() {
        if (instance == null) {
            instance = new EntrantDocumentRepository();
        }

        return instance;
    }
}
