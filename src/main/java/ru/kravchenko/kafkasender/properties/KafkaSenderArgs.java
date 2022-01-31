package ru.kravchenko.kafkasender.properties;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class KafkaSenderArgs {

    private String hosts;
    private String filePath;

}
