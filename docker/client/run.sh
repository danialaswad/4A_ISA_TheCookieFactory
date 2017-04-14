#!/bin/bash

# the image will be removed when stopped
docker run --rm -it -v `pwd`:/host devops/tcf-client

# ^C to stop
