#!/bin/bash

apt update


#				Gitlab runner
os=debian
dist=stretch
gpg_key_url="https://packages.gitlab.com/runner/gitlab-runner/gpgkey"
apt_config_url="https://packages.gitlab.com/install/repositories/runner/gitlab-runner/config_file.list?os=${os}&dist=${dist}&source=script"
apt_source_path="/etc/apt/sources.list.d/runner_gitlab-runner.list"

curl -sSf "${apt_config_url}" > $apt_source_path
curl -L "${gpg_key_url}" 2> /dev/null | apt-key add - &>/dev/null


apt install -q -y curl debian-archive-keyring apt-transport-https
apt upgade -y




 