/*
 * (C) Copyright Resse Christophe 2021 - All Rights Reserved
 * -----------------------------------------------------------------------------------------------
 * All information contained herein is, and remains the property of
 * Resse Christophe. and its suppliers, if any. The intellectual and technical
 * concepts contained herein are proprietary to Resse C. and its
 * suppliers and may be covered by U.S. and Foreign Patents, patents
 * in process, and are protected by trade secret or copyright law.
 *
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained from
 * Resse Christophe (christophe.resse@gmail.com).
 * -----------------------------------------------------------------------------------------------
 */
package com.hemajoo.commerce.cherry.backend.persistence.document.repository;


import com.hemajoo.commerce.cherry.backend.persistence.document.entity.DocumentServer;
import com.hemajoo.commerce.cherry.backend.shared.base.query.condition.QueryConditionException;
import com.hemajoo.commerce.cherry.backend.shared.document.DocumentException;
import com.hemajoo.commerce.cherry.backend.shared.document.DocumentQuery;
import lombok.NonNull;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

/**
 * Document persistence service.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public interface IDocumentService
{
    /**
     * Returns the entity manager.
     * @return Entity manager.
     */
    EntityManager getEntityManager();

    /**
     * Returns the underlying repository.
     * @return Document repository.
     */
    IDocumentRepository getRepository();

    /**
     * Returns the number of documents.
     * @return Number of documents.
     */
    Long count();

    /**
     * Finds a document given its identifier.
     * @param id Document identifier.
     * @return Document if found, null otherwise.
     * @throws DocumentException raised if the given document id has not been found!
     */
    DocumentServer findById(UUID id) throws DocumentException;

    /**
     * Saves a document.
     * @param document Document to save.
     * @return Saved document.
     * @throws DocumentException Raised if an error occurred while trying to save the document.
     */
    DocumentServer save(DocumentServer document) throws DocumentException;

    /**
     * Saves and flush a document.
     * @param document Document.
     * @return Saved document.
     */
    DocumentServer saveAndFlush(DocumentServer document);

    /**
     * Deletes a document given its identifier.
     * @param id Document identifier.
     * @throws DocumentException Raised if an error occurred while trying to delete the document.
     */
    void deleteById(UUID id) throws DocumentException;

    /**
     * Returns all the documents.
     * @return List of documents.
     */
    List<DocumentServer> findAll();

    /**
     * Loads the content (media file) of the document.
     * @param document Document.
     * @throws DocumentException Raised if an error occurred while trying to load the document.
     */
    void loadContent(DocumentServer document) throws DocumentException;

    /**
     * Loads the content (media file) of the document.
     * @param documentId Document identifier.
     * @throws DocumentException Raised if an error occurred while trying to load the document.
     */
    void loadContent(UUID documentId) throws DocumentException;

    /**
     * Searches for documents given some criteria.
     * @param search Search object.
     * @return List of documents matching the given criteria.
     */
    List<DocumentServer> search(final @NonNull DocumentQuery search) throws QueryConditionException;
}
