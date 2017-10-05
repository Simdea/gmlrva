# Changelog
All notable changes to this project will be documented in this file.
The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)

## [Unreleased]

## [1.3] - 2017-10-03
### Added
- [DiffUtil](https://developer.android.com/reference/android/support/v7/util/DiffUtil.html) support.

### Changed
- GMLRVA Sample's list data to support items with inner option panel.

### Removed
- Add, Remove, Update and Swap procedures from Generic Adapter implementation, which became obsolete with DiffUtil
usage.

### Fixed
- Issue #1, incorrect swap function implementation, which is no longer needed.

## [1.2] - 2017-09-09
### Fixed
- Issue #1, incorrect swap function implementation.

## [1.1] - 2017-08-09
### Added
- New Generic RecyclerView Layout examples.

## [1.0] - 2017-08-02

Initial release.