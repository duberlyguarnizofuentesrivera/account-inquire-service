/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.enums;

/**
 * Defines the different types of categories for a client.
 * Corporate clients may be Pyme. Regular and corporate may be
 * non-passive account client (this is, someone who does not
 * have a passive account in the bank) and they both can be VIP clients.
 */
public enum ClientSpecialType {
  NONE,
  NON_PASSIVE_CLIENT,
  PYME_CLIENT,
  VIP_CLIENT
}
