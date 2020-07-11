#!/bin/bash
if test -f "/etc/init.d/ms-recherche"; then
  sudo service ms-recherche stop
fi