package com.harun.springkafkasms.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Harun Rashid
 * User:shami
 * Date:12/02/2024
 * Time:01:55
 */


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmsRequest {
    private String recipient;
    private String text;
    private String sender;
}
