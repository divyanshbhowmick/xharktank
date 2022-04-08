package com.divyansh.xharktank.entity;

import com.divyansh.xharktank.utils.serializers.FloatValueSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "offer")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Offer {
    @Id
    @JsonProperty("id")
    @Column(name = "offer_id")
    @JsonSerialize(using = ToStringSerializer.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    @NotBlank(message = "investor can't be blank")
    @Column(name = "investor", nullable = false)
    private String investor;

    @NotNull(message = "amount can't be blank")
    @Column(name = "amount", nullable = false)
//    @JsonSerialize(using = FloatValueSerializer.class)
    private Float amount;

    @Column(name = "equity", nullable = false)
    @NotNull(message = "equity can't be blank")
//    @JsonSerialize(using = FloatValueSerializer.class)
    @Min(value = 0, message = "Equity can't be less than 0%")
    @Max(value = 100, message = "Equity can't be greater than 100%")
    private Float equity;

    @Column(name = "comment", nullable = false, columnDefinition = "TEXT")
    private String comment;

    @NonNull
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name = "fk_pitch_id", referencedColumnName = "pitch_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private Pitch pitch;
}
