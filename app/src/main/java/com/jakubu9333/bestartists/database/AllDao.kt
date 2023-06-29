package com.jakubu9333.bestartists.database


import androidx.room.*
import kotlinx.coroutines.flow.Flow


/**
 *
 * @author Jakub Uhlarik
 */


@Dao
interface AllDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertEntry(entry: PastEntry): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertArtist(artist: ArtistEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertArtists(artists: List<ArtistEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMapping(mapping: EntriesArtistsMap)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMappings(mapping: List<EntriesArtistsMap>)

    @Query("SELECT * from pastRequests WHERE entryId=:key")
    fun get(key: Long): PastEntry?

    @Transaction
    fun insertEntryWitArtists(artists: List<ArtistEntity>){
        val entryId = insertEntry(PastEntry())
        insertArtists(artists)
        val entryArtistMapping = artists.map { artistEntity -> EntriesArtistsMap(entryId, artistEntity.id) }
        insertMappings(entryArtistMapping)
    }

    @Query(
        "SELECT artistId,name,imageUrl from artists " +
                "inner join entry_artist_join_table on artists.artistId=entry_artist_join_table.artistIdRef " +
                "inner join  pastRequests on entry_artist_join_table.entryIdRef=pastRequests.entryId where entryId=:key"
    )
    fun getArtistsByEntry(key: Long): Flow<List<ArtistEntity>>

    @Query("Select * from entry_artist_join_table")
    fun getArtistsAll(): Flow<List<EntriesArtistsMap>>

    @Query("DELETE FROM pastRequests where entryId=:key")
    fun clearEntry(key: Long)

    @Query("DELETE FROM pastRequests")
    fun clear()

    @Query("SELECT * FROM pastRequests ORDER BY entryId DESC limit 1")
    fun getLastEntry(): PastEntry

    @Query("SELECT * FROM pastRequests ORDER BY entryId DESC")
    fun getAllEntries(): Flow<List<PastEntry>>


    @Query("SELECT * FROM artists")
    fun getAllArtistsWithEntries(): List<ArtistWithEntriesList>

    @Query("SELECT * FROM pastRequests where entryId=:key")
    fun getEntryWithArtists(key: Long): EntriesWithArtistsList

}