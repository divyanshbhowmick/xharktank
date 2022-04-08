package com.divyansh.xharktank.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pitch")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pitch {

    @Id
    @JsonProperty("id")
    @Column(name = "pitch_id")
    @JsonSerialize(using = ToStringSerializer.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pitchId;

    @NotBlank(message = "pitch title can't be blank")
    @Column(name = "pitch_title", nullable = false)
    private String pitchTitle;

    @NotBlank(message = "pitch idea can't be blank")
    @Column(name = "pitch_idea", nullable = false, columnDefinition = "TEXT")
    private String pitchIdea;

    @NotNull(message = "ask amount can't be blank")
    @Column(name = "ask_amount", nullable = false)
    @Min(value = 0, message = "Ask amount can't be less than 0%")
    private Float askAmount;

    @Column(name = "equity", nullable = false)
    @NotNull(message = "equity can't be blank")
    @Min(value = 0, message = "Equity can't be less than 0%")
    @Max(value = 100, message = "Equity can't be greater than 100%")
    private Float equity;

    @NotBlank(message = "entrepreneur can't be blank")
    @Column(name = "entrepreneur", nullable = false)
    private String entrepreneur;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pitch")
    private List<Offer> offers;
}
