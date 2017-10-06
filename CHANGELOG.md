# Changelog
All notable changes to this project will be documented in this file.
The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)

## [Unreleased]

## [1.4.2] - 2017-10-06
### Added
- New carousel item with a single text sample.

### Fixed
- [#5](https://github.com/Simdea/gmlrva/issues/5), Not updating view types when changes occurred.

## [1.4.1] - 2017-10-05
### Fixed
- [#5](https://github.com/Simdea/gmlrva/issues/5), Not updating view types when add, remove or update the recycler view elements.

## [1.4] - 2017-10-05
### Added
- CHANGELOG.md file
- All [DiffUtil](https://developer.android.com/reference/android/support/v7/util/DiffUtil.html) calculations are
currently processed in a background worker thread, while preserving adapter state consistency.

### Fixed
- [DiffUtil](https://developer.android.com/reference/android/support/v7/util/DiffUtil.html) implementation.
- [#2](https://github.com/Simdea/gmlrva/issues/2), merge error when executing task: ':app:processDebugManifest'.
- [#3](https://github.com/Simdea/gmlrva/issues/3), missing CHANGELOG.md file.
- [#4](https://github.com/Simdea/gmlrva/issues/4), DiffUtil background work implementation missing.

## [1.3] - 2017-10-03
### Added
- [DiffUtil](https://developer.android.com/reference/android/support/v7/util/DiffUtil.html) support.

### Changed
- GMLRVA Sample's list data to support items with inner option panel.

### Removed
- Add, Remove, Update and Swap procedures from Generic Adapter implementation, which became obsolete with DiffUtil
usage.

### Fixed
- [#1](https://github.com/Simdea/gmlrva/issues/1), incorrect swap function implementation, which is no longer needed.

## [1.2] - 2017-09-09
### Fixed
- [#1](https://github.com/Simdea/gmlrva/issues/1), incorrect swap function implementation.

## [1.1] - 2017-08-09
### Added
- New Generic RecyclerView Layout examples.

## [1.0] - 2017-08-02

Initial release.