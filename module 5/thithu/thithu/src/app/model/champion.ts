import {ChampionType} from './champion-type';

export interface Champion {
  id?: number;
  name?: string;
  nation?: string;
  genre?: string;
  championType?: ChampionType;
}
