#!/usr/bin/env bash
echo "Starting atm-machine mock..."
docker-compose -f ./mock/atm-machine-mock.yml up -d
echo "Started"
