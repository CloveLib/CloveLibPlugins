# CloveLibPlugins

Minecraft server mods for Fabric built on the CloveLib API framework.

[![Deploy CloveLibAPI](https://github.com/CloveLib/CloveLibPlugins/actions/workflows/build-clovelibapi.yml/badge.svg)](https://github.com/CloveLib/CloveLibPlugins/actions/workflows/build-clovelibapi.yml)
[![Deploy CPC](https://github.com/CloveLib/CloveLibPlugins/actions/workflows/build-cpc.yml/badge.svg)](https://github.com/CloveLib/CloveLibPlugins/actions/workflows/build-cpc.yml)
[![Deploy EndRace](https://github.com/CloveLib/CloveLibPlugins/actions/workflows/build-endrace.yml/badge.svg)](https://github.com/CloveLib/CloveLibPlugins/actions/workflows/build-endrace.yml)
[![Deploy Estrocord](https://github.com/CloveLib/CloveLibPlugins/actions/workflows/build-estrocord.yml/badge.svg)](https://github.com/CloveLib/CloveLibPlugins/actions/workflows/build-estrocord.yml)
[![Deploy JailedWings](https://github.com/CloveLib/CloveLibPlugins/actions/workflows/build-jailedwings.yml/badge.svg)](https://github.com/CloveLib/CloveLibPlugins/actions/workflows/build-jailedwings.yml)
[![Deploy StatsEnd](https://github.com/CloveLib/CloveLibPlugins/actions/workflows/build-statsend.yml/badge.svg)](https://github.com/CloveLib/CloveLibPlugins/actions/workflows/build-statsend.yml)
[![Deploy WingSync](https://github.com/CloveLib/CloveLibPlugins/actions/workflows/build-wingsync.yml/badge.svg)](https://github.com/CloveLib/CloveLibPlugins/actions/workflows/build-wingsync.yml)
[![CodeFactor](https://www.codefactor.io/repository/github/clovelib/CloveLibPlugins/badge)](https://www.codefactor.io/repository/github/clovelib/CloveLibPlugins)

## Plugins

| Plugin | Description | Docs |
|--------|-------------|------|
| **CloveLibAPI** | Core library - ban system, jail API, cross-plugin events | [📖](https://www.clovelib.win/docs/clovelibapi) |
| **ClovesPluralCraft** | Plural system support with message proxying | [📖](https://www.clovelib.win/docs/cpc) |
| **Estrocord** | Flight, vein mining, spawn eggs, potions, teleports | [📖](https://www.clovelib.win/docs/estrocord) |
| **WingSync** | Discord whitelist sync with ban integration | [📖](https://www.clovelib.win/docs/wingsync) |
| **EndRace** | Race-to-the-End tracking with scoreboard | [📖](https://www.clovelib.win/docs/endrace) |
| **JailedWings** | Jail system with timed releases | [📖](https://www.clovelib.win/docs/jailedwings) |
| **StatsEnd** | Dragon event tracking and achievements | [📖](https://www.clovelib.win/docs/statsend) |

## Quick Start

```bash
# Build all
./gradlew build

# Build specific plugin
./gradlew :pluginname:shadowJar
```

**Installation:** Download from [CloveLib Studios](https://www.clovelib.win)

## Contributors

<a href="https://github.com/CloveLib/CloveLibPlugins/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=CloveLib/CloveLibPlugins" />
</a>

## License

MIT © 2025 Clove Twilight | [Website](https://www.clovelib.win)
