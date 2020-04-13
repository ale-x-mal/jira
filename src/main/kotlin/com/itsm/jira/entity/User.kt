package com.itsm.jira.entity

import com.fasterxml.jackson.annotation.*
import io.swagger.annotations.ApiModelProperty
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
data class User(

        @Id
        @JsonProperty("id")
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @ApiModelProperty(notes = "Id of the User")
        val id: Long = 0L,

        @JsonProperty("firstName")
        @Column(name = "first_name", length = 50)
        @ApiModelProperty(notes = "First name of the User")
        val firstName: String = "",

        @JsonProperty("lastName")
        @Column(name = "last_name", length = 50)
        @ApiModelProperty(notes = "Last name of the User")
        val lastName: String = "",

        @JsonProperty("middleName")
        @Column(name = "middle_name", length = 50)
        @ApiModelProperty(notes = "Middle name of the User")
        val middleName: String = "",

//        @JsonProperty("dataOfBirth")
        @Column(name = "data_of_birth")
        @Temporal(TemporalType.DATE)
        @ApiModelProperty(notes = "Data Of Birth User")
        val dataOfBirth: Date? = null,

        @JsonProperty("position")
        @Column(name = "position", length = 50)
        @ApiModelProperty(notes = "Position of the User")
        val position: String = "",

        @JsonProperty("department")
        @Column(name = "department", length = 50)
        @ApiModelProperty(notes = "Department of the User")
        val department: String = "",

        @JsonProperty("email")
        @Column(name = "email", length = 50)
        @ApiModelProperty(notes = "Email of the User")
        val email: String = "",

        @JsonProperty("phone")
        @Column(name = "phone", length = 50)
        @ApiModelProperty(notes = "Phone of the User")
        val phone: String = "",

        @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "creator")
        @ApiModelProperty(notes = "Tickets of the User")
//        @JsonManagedReference
//        @JsonBackReference
        var tickets: List<Ticket>? = emptyList()
)
