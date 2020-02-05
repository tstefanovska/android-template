package mk.webfactory.template.data.storage

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Generic single object store.
 *
 * Note that the storage may cache values for any subsequent queries.
 */
interface Storage<T> {
    /**
     * @return the saved data.
     * @throws StorageException
     * @see .isLocal
     */
    fun save(t: T): Single<T>

    /** @throws StorageException
     */
    fun retrieve(): Single<T>

    /**
     * @return completes or calls onError if an error occurs
     * @throws StorageException
     */
    fun delete(): Completable

    /** Test whether the storage is local or remote.  */
    val isLocal: Boolean

    /** Returns the identifier that uniquely identifies this type of Storage.  */
    val storageId: String
}