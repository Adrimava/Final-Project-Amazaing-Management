export class PlayerDTO {

    constructor(
        private _playerName: string,
        private _money: number,
        private _photo: string
    ) { }

    public get photo(): string {
        return this._photo;
    }
    public set photo(value: string) {
        this._photo = value;
    }
    public get money(): number {
        return this._money;
    }
    public set money(value: number) {
        this._money = value;
    }
    public get playerName(): string {
        return this._playerName;
    }
    public set playerName(value: string) {
        this._playerName = value;
    }

}
